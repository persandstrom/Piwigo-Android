/*
 * Copyright 2015 Phil Bayfield https://philio.me
 * Copyright 2015 Piwigo Team http://piwigo.org
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

package org.piwigo.io.provider;

import org.piwigo.io.RestService;
import org.piwigo.manager.SessionManager;

import rx.Observable;
import rx.Scheduler;

public abstract class BaseProvider<T> {

    protected SessionManager sessionManager;

    protected RestService restService;

    protected Scheduler ioScheduler;

    protected Scheduler uiScheduler;

    protected Observable<T> observable;

    public BaseProvider(SessionManager sessionManager, RestService restService, Scheduler ioScheduler, Scheduler uiScheduler) {
        this.sessionManager = sessionManager;
        this.restService = restService;
        this.ioScheduler = ioScheduler;
        this.uiScheduler = uiScheduler;
    }

    protected <T> Observable.Transformer<T, T> applySchedulers() {
        return observable -> observable.subscribeOn(ioScheduler)
                .observeOn(uiScheduler);
    }

    /**
     * Create observable and return it
     */
    abstract Observable<T> create();

}
