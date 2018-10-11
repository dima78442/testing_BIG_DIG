package com.dima.testing_big_dig.View.fragments.History_fragment;


public class Reference {

    private String url;
    private int status;
    private String time;

    public Reference(String url, int status, String time) {
        this.url = url;
        this.status = status;
        this.time = time;
    }

    public Reference(){

    }

    public Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {

        private String url;
        private int status;
        private String time;


        public Builder setUrl(String url) {
            this.url = url;

            return this;
        }

        public Builder setStatus(int status) {
            this.status = status;

            return this;
        }

        public Builder setTimeAt(String time) {
            this.time = time;

            return this;
        }

        public Reference build() {
            return new Reference(this.url, this.status, this.time);
        }

    }

    public String getUrl() {
        return url;
    }

    public int getStatus() {
        return status;
    }

    public String getTimeAt() {
        return time;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTimeAt(String time) {
        this.time = time;
    }
}
