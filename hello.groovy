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
 
/**
 *
 * Globally bound variables:
 *
 * log (org.slf4j.Logger)
 * repositories (org.artifactory.repo.Repositories)
 * security (org.artifactory.security.Security)
 * searches (org.artifactory.search.Searches) [since: 2.3.4]
 * builds (org.artifactory.build.Builds) [since 2.5.2]
 *
 * ctx (org.artifactory.spring.InternalArtifactoryContext) - NOT A PUBLIC API - FOR INTERNAL USE ONLY!
 */


 executions {
    hello(users: ['anonymous']) {
        log.info("== Custom plugin executed ==")
        message = '{"status":"okay"}'
        status = 200
    }
}