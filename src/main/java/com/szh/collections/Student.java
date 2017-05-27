package com.szh.collections;

class Student implements Comparable{
        private String name;  
        private int age;  
        public int compareTo(Object obj){  
            if(!(obj instanceof Student)){  
                throw new RuntimeException("传的类型不对");  
            }  
            Student s=(Student) obj;  
            if(this.age>s.age){  
                return 1;  
            }  
            if(this.age==s.age){  
                return this.name.compareTo(s.name);  
            }  
            return -1;  
        }  
        Student(String name,int age){  
            this.name=name;  
            this.age=age;  
        }  
        public String getName(){  
            return name;  
        }  
        public int getAge(){  
            return age;  
        }  
    }  