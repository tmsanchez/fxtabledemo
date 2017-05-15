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
package mx.tmsanchez.fxtabledemo.service;

import java.util.ArrayList;
import java.util.List;
import mx.tmsanchez.fxtabledemo.domain.Person;

/**
 *
 * @author Tito Sanchez
 */
public class PersonService {

    public List<Person> getPersons() {
        List<Person> personList = new ArrayList();

        personList.add(new Person(1, "Jacob", "Smith", "jacob.smith@example.com"));
        personList.add(new Person(2, "Isabella", "Johnson", "isabella.johnson@example.com"));
        personList.add(new Person(3, "Ethan", "Williams", "ethan.williams@example.com"));
        personList.add(new Person(4, "Emma", "Jones", "emma.jones@example.com"));
        personList.add(new Person(5, "Michael", "Brown", "michael.brown@example.com"));
        return personList;
    }
}
