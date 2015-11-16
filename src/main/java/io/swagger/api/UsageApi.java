package io.swagger.api;

import io.swagger.model.*;

import io.swagger.model.Error;
import io.swagger.model.DataUsage;

import java.util.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.concurrent.ThreadLocalRandom;
import static org.springframework.http.MediaType.*;

@Controller
@RequestMapping(value = "/usage", produces = {APPLICATION_JSON_VALUE})
@Api(value = "/usage", description = "the usage API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2015-11-16T10:43:27.803Z")
public class UsageApi {

    Logger logger = LoggerFactory.getLogger(UsageApi.class);
  

  @ApiOperation(value = "Hourly Usage", notes = "Returns hourly usage for given date range and Record ID", response = DataUsage.class, responseContainer = "List")
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "An array of Data Usage objects"),
    @ApiResponse(code = 200, message = "Unexpected error") })
  @RequestMapping(value = "", 
    produces = { "application/json" }, 
    
    method = RequestMethod.GET)
  public ResponseEntity<List<DataUsage>> usageGet(@ApiParam(value = "Record ID", required = true) @RequestParam(value = "recordId", required = true) String recordId


,
    @ApiParam(value = "Start date/time", required = true) @RequestParam(value = "start", required = true)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    Date start


,
    @ApiParam(value = "End date/time", required = true) @RequestParam(value = "end", required = true)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    Date end


)
      throws NotFoundException {

      long incrementMs = 60*60*1000; //1 hour

      if(start.equals(end)){
          //If start=end assume request for 24 hours prior to end-date
          start.setTime(start.getTime()-1440*60*1000);
          logger.info("Start and End dates equal.  Returning usage for 24 hours up to the End date.");
      }

      if(!start.before(end)){
          throw new NotFoundException(HttpStatus.BAD_REQUEST.value(), "Start date is not earlier than end date");
      }

      List<DataUsage> list = new ArrayList<DataUsage>();

      Date startRounded = DateUtils.round(start, Calendar.HOUR_OF_DAY);
      Date endRounded = DateUtils.round(end, Calendar.HOUR_OF_DAY);

      logger.info("Returning usage for recordId="+recordId+", start="+startRounded+", end="+endRounded);

      for(; startRounded.before(endRounded); startRounded.setTime(startRounded.getTime()+incrementMs)) {
          logger.info("\t-> Returning hourly usage for recordId="+recordId+", hour="+startRounded.getTime());
          DataUsage duMetered = createDataUsage(startRounded, incrementMs, recordId, "SUB_"+recordId, 41, 50000000000L);
          DataUsage duUnMetered = createDataUsage(startRounded, incrementMs, recordId, "SUB_"+recordId, 61, 10000000000L);

          list.add(duMetered);
          list.add(duUnMetered);
      }

      return new ResponseEntity<List<DataUsage>>(list, HttpStatus.OK);
  }

    private DataUsage createDataUsage(Date usageForPeriodStart, long incrementMs, String recordId, String subscriberId, int ratingId, long maxUsage) {
        DataUsage du = new DataUsage();

        long upload = ThreadLocalRandom.current().nextLong(0, maxUsage);
        long download = ThreadLocalRandom.current().nextLong(0, maxUsage);
        du.setDownload(download);
        du.setUpload(upload);
        du.setTotal(upload + download);
        du.setRatingId(ratingId);
        du.setRecordId(recordId);
        du.setSubscriberId(subscriberId);
        du.setEventDatetime(new Date(usageForPeriodStart.getTime()+incrementMs)); //add increment since api returns end of period

        return du;
    }


}
