package com.chaquo.python.utils;

    public class Person {
        private String name;
        private String height;


        public Person(String name) {
            this.name = name;
            this.height = "Filler";
        }

        public String getName() {
            return name;
        }

        public String getHeight() {
            return "Filler";
        }

        public void setName(String name) {
            this.name = name;
        }


    }

