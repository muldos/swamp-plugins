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

import static com.google.common.collect.Multimaps.forMap 
import org.apache.commons.lang3.StringUtils
import org.artifactory.api.repo.exception.ItemNotFoundRuntimeException
import org.artifactory.exception.CancelException

import groovy.json.JsonSlurper
import groovy.time.TimeCategory
import groovy.time.TimeDuration
import groovy.transform.Field

import java.text.SimpleDateFormat


@Field final String DEFAULT_PROP_NAME = "tested"
@Field final String DEFAULT_PROP_VALUE = "ok"
@Field final String DEFAULT_BUNDLE_TAG = "bundleTag"
@Field final String DEFAULT_BUNDLE_TAG_VALUE = "1.2.3"

def pluginGroup = 'bundler'
 executions {
    hello(users: ['anonymous']) {
        log.info("== Custom plugin executed ==")
        message = '{"status":"okay"}'
        status = 200
    }

    tagBundleComponents(groups: [pluginGroup]) { params ->
        def propName = params['propName']
        def propValue = params['propValue']
        def repo = params['repo']
        def tagName = params['tagName']
        def tagValue = params['tagValue']

        log.info("== Custom plugin executed ==")
        def artifactsToTag = searches.itemsByProperties(forMap([propName: propValue]), repo)
        artifactsToTag.each { RepoPath path ->
            log.info("path to tag== ${path.name} ==")
        }
        message = '{"status":"resources tagged"}'
        status = 200
    }

}