package com.yurets_y.application.entity;

import java.util.Date;
import java.util.Objects;

public class WaitingTimelineEntity {

    private String serviceId;

    private String questionId;

    private ResponseType responseType;

    private Date date;

    private int waitingTime;

    public WaitingTimelineEntity() {
    }

    public WaitingTimelineEntity(String serviceId, String questionId, ResponseType responseType, Date date, int waitingTime) {
        this.serviceId = serviceId;
        this.questionId = questionId;
        this.responseType = responseType;
        this.date = date;
        this.waitingTime = waitingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaitingTimelineEntity that = (WaitingTimelineEntity) o;
        return Objects.equals(serviceId, that.serviceId) &&
                Objects.equals(questionId, that.questionId) &&
                responseType == that.responseType &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(serviceId, questionId, responseType, date);
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    @Override
    public String toString() {
        return "WaitingTimelineEntity{" +
                "serviceId='" + serviceId + '\'' +
                ", questionId='" + questionId + '\'' +
                ", responseType=" + responseType +
                ", date=" + date +
                ", waitingTime=" + waitingTime +
                '}';
    }
}
