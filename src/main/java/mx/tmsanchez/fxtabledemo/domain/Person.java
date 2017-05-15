/*
 * Copyright 2017 Tito Sanchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mx.tmsanchez.fxtabledemo.domain;

import java.io.Serializable;

/**
 *
 * @author Tito Sanchez
 */
public class Person implements Serializable {

    private Integer person;
    private String firstName;
    private String lastName;
    private String email;

    public Person() {
    }

    public Person(Integer person, String firstName, String lastName, String email) {
        this.person = person;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    
    

    public Integer getPerson() {
        return person;
    }

    public void setPerson(Integer person) {
        this.person = person;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}



