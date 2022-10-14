package ru.norddigital.ClientABDM.soap.operations;

import lombok.Data;

@Data
public abstract class IssoOperations {

    protected String barrierName;
    protected String buildOrg;
    protected String buildYear;
    protected String city;
    protected String description;
    protected String dist;
    protected String examOrg;
    protected String id;
    protected String id2;
    protected String issoSuperType;
    protected String issoType;
    protected String kak;
    protected String kn3;
    protected String knk;
    protected String length;
    protected String location;
    protected String obst;
    protected String operOrg;
    protected String plan;
    protected String proOrg;
    protected String raiting;
    protected String raitingDate;
    protected String region;
    protected String road;
    protected String roadKategory;
    protected String strain;
    protected String upr;
    protected String width;

    protected String errorResponseMessage;
}
