package com.yurets_y.entity;

import java.util.Date;
import java.util.Objects;

public class QueryEntity {
    private String serviceId;

    private String questionId;

    private ResponseType responseType;

    private Date dateFrom;

    private Date dateUntil;

    public QueryEntity() {
    }

    public QueryEntity(String serviceId, String questionId, ResponseType responseType, Date dateFrom, Date dateUntil) {
        this.serviceId = serviceId;
        this.questionId = questionId;
        this.responseType = responseType;
        this.dateFrom = dateFrom;
        this.dateUntil = dateUntil;
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

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateUntil() {
        return dateUntil;
    }

    public void setDateUntil(Date dateUntil) {
        this.dateUntil = dateUntil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryEntity that = (QueryEntity) o;
        return Objects.equals(serviceId, that.serviceId) &&
                Objects.equals(questionId, that.questionId) &&
                responseType == that.responseType &&
                Objects.equals(dateFrom, that.dateFrom) &&
                Objects.equals(dateUntil, that.dateUntil);
    }

    @Override
    public int hashCode() {

        return Objects.hash(serviceId, questionId, responseType, dateFrom, dateUntil);
    }

    @Override
    public String toString() {
        return "QueryEntity{" +
                "serviceId='" + serviceId + '\'' +
                ", questionId='" + questionId + '\'' +
                ", responseType=" + responseType +
                ", dateFrom=" + dateFrom +
                ", dateUntil=" + dateUntil +
                '}';
    }
}
