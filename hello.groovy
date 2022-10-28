/*
 * Copyright (C) 2011 JFrog Ltd.
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
 
import org.apache.commons.lang3.StringUtils
import org.artifactory.api.repo.exception.ItemNotFoundRuntimeException
import org.artifactory.exception.CancelException

import groovy.json.JsonSlurper
import groovy.time.TimeCategory
import groovy.time.TimeDuration
import groovy.transform.Field

import java.text.SimpleDateFormat

@Field final String CONFIG_FILE_PATH = "plugins/${this.class.name}.json"
@Field final String PROPERTIES_FILE_PATH = "plugins/${this.class.name}.properties"
@Field final String DEFAULT_TIME_UNIT = "month"
@Field final int DEFAULT_TIME_INTERVAL = 1

class Global {
    static Boolean stopCleaning = false
    static Boolean pauseCleaning = false
    static int paceTimeMS = 0
}
def pluginGroup = 'cleaners'
 executions {
    hello(users: ['anonymous']) {
        log.info("== Custom plugin executed ==")
        message = '{"status":"okay"}'
        status = 200
    }

    cleanup(groups: [pluginGroup]) { params ->
        def timeUnit = params['timeUnit'] ? params['timeUnit'][0] as String : DEFAULT_TIME_UNIT
        def timeInterval = params['timeInterval'] ? params['timeInterval'][0] as int : DEFAULT_TIME_INTERVAL
        def repos = params['repos'] as String[]
        def dryRun = params['dryRun'] ? new Boolean(params['dryRun'][0]) : false
        def disablePropertiesSupport = params['disablePropertiesSupport'] ? new Boolean(params['disablePropertiesSupport'][0]) : false
        def paceTimeMS = params['paceTimeMS'] ? params['paceTimeMS'][0] as int : 0

        log.info("== Custom cleanup plugin executed ==")
        log.debug("variable dump : ${timeUnit} - ${repos}")
    }

}