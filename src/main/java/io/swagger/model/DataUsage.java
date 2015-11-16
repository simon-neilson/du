package io.swagger.model;

import java.util.Date;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2015-11-16T10:43:27.803Z")
public class DataUsage  {
  
  private String recordId = null;
  private String subscriberId = null;
  private Date eventDatetime = null;
  private Integer ratingId = null;
  private Long total = null;
  private Long upload = null;
  private Long download = null;

  
  /**
   * Record identifier
   **/
  @ApiModelProperty(value = "Record identifier")
  @JsonProperty("recordId")
  public String getRecordId() {
    return recordId;
  }
  public void setRecordId(String recordId) {
    this.recordId = recordId;
  }

  
  /**
   * Subscriber identifier
   **/
  @ApiModelProperty(value = "Subscriber identifier")
  @JsonProperty("subscriberId")
  public String getSubscriberId() {
    return subscriberId;
  }
  public void setSubscriberId(String subscriberId) {
    this.subscriberId = subscriberId;
  }

  
  /**
   * Timestamp of the event representing the hour of usage (hourly usage up to this time)
   **/
  @ApiModelProperty(value = "Timestamp of the event representing the hour of usage (hourly usage up to this time)")
  @JsonProperty("eventDatetime")
  //@DateTimeFormat(pattern="yyyy-MM-dd")
  public Date getEventDatetime() {
    return eventDatetime;
  }
  public void setEventDatetime(Date eventDatetime) {
    this.eventDatetime = eventDatetime;
  }

  
  /**
   * Rating group ID. i.e. Metered or un-metered data
   **/
  @ApiModelProperty(value = "Rating group ID. i.e. Metered or un-metered data")
  @JsonProperty("ratingId")
  public Integer getRatingId() {
    return ratingId;
  }
  public void setRatingId(Integer ratingId) {
    this.ratingId = ratingId;
  }

  
  /**
   * Total hourly data usage volume
   **/
  @ApiModelProperty(value = "Total hourly data usage volume")
  @JsonProperty("total")
  public Long getTotal() {
    return total;
  }
  public void setTotal(Long total) {
    this.total = total;
  }

  
  /**
   * Upload hourly data usage volume
   **/
  @ApiModelProperty(value = "Upload hourly data usage volume")
  @JsonProperty("upload")
  public Long getUpload() {
    return upload;
  }
  public void setUpload(Long upload) {
    this.upload = upload;
  }

  
  /**
   * Download hourly data usage volume
   **/
  @ApiModelProperty(value = "Download hourly data usage volume")
  @JsonProperty("download")
  public Long getDownload() {
    return download;
  }
  public void setDownload(Long download) {
    this.download = download;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataUsage {\n");
    
    sb.append("  recordId: ").append(recordId).append("\n");
    sb.append("  subscriberId: ").append(subscriberId).append("\n");
    sb.append("  eventDatetime: ").append(eventDatetime).append("\n");
    sb.append("  ratingId: ").append(ratingId).append("\n");
    sb.append("  total: ").append(total).append("\n");
    sb.append("  upload: ").append(upload).append("\n");
    sb.append("  download: ").append(download).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
