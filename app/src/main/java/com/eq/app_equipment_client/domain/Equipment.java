package com.eq.app_equipment_client.domain;

public class Equipment {
    /**
     * data : {"Status":3,"apparatus":null,"eqid":2,"Latitude":1,"Synopsis":"ss","Longitude":0}
     * Result : 1
     */

    private DataBean data;
    private int Result;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getResult() {
        return Result;
    }

    public void setResult(int Result) {
        this.Result = Result;
    }

    public static class DataBean {
        /**
         * Status : 3
         * apparatus : null
         * eqid : 2
         * Latitude : 1
         * Synopsis : ss
         * Longitude : 0
         */

        private int Status;
        private Object apparatus;
        private int eqid;
        private double Latitude;
        private String Synopsis;
        private double Longitude;

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public Object getApparatus() {
            return apparatus;
        }

        public void setApparatus(Object apparatus) {
            this.apparatus = apparatus;
        }

        public int getEqid() {
            return eqid;
        }

        public void setEqid(int eqid) {
            this.eqid = eqid;
        }

        public double getLatitude() {
            return Latitude;
        }

        public void setLatitude(double Latitude) {
            this.Latitude = Latitude;
        }

        public String getSynopsis() {
            return Synopsis;
        }

        public void setSynopsis(String Synopsis) {
            this.Synopsis = Synopsis;
        }

        public double getLongitude() {
            return Longitude;
        }

        public void setLongitude(double Longitude) {
            this.Longitude = Longitude;
        }
    }
}
