/*
 * Copyright 2010 Robert Fletcher
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codehaus.groovy.grails.plugin.springevents.test

class Album {

	String artist
	String name
	List tracks = []

	static hasMany = [tracks: Song]

	static constraints = {
		artist blank: false
		name blank: false, unique: "artist"
	}

	void afterInsert() {
		publishEvent new InsertEvent(this)
	}

	void afterUpdate() {
		publishEvent new UpdateEvent(this)
	}

	void afterDelete() {
		publishEvent new DeleteEvent(this)
	}
}

