package com.eq.app_equipment_client.domain;

public class aa {
    /**
     * 结果 : {"Result":"注册成功"}
     */

    private 结果Bean 结果;

    public 结果Bean get结果() {
        return 结果;
    }

    public void set结果(结果Bean 结果) {
        this.结果 = 结果;
    }

    public static class 结果Bean {
        /**
         * Result : 注册成功
         */

        private String Result;

        public String getResult() {
            return Result;
        }

        public void setResult(String Result) {
            this.Result = Result;
        }
    }
}
