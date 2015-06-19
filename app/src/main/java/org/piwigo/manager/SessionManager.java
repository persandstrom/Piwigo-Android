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

package org.piwigo.manager;

import android.accounts.Account;
import android.accounts.AccountManager;

import org.piwigo.io.DynamicEndpoint;

public class SessionManager {

    private AccountManager accountManager;

    private DynamicEndpoint endpoint = new DynamicEndpoint();

    private String cookie;

    private String token;

    public SessionManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    /**
     * Populate the session data from an account
     *
     * @param account Account to get session data from
     */
    public void from(Account account) {

    }

    /**
     * Set the endpoint URL
     *
     * @param url New endpoint URL
     */
    public void setUrl(String url) {
        endpoint.setUrl(url);
    }

    /**
     * Get the endpoint
     *
     * @return Retrofit endpoint
     */
    public DynamicEndpoint getEndpoint() {
        return endpoint;
    }

    /**
     * Set the session cookie
     *
     * @param cookie New session cookie
     */
    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    /**
     * Get the session cookie
     *
     * @return Current session cookie
     */
    public String getCookie() {
        return cookie;
    }

    /**
     * Set the user token
     *
     * @param token New user token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Get the user token
     *
     * @return Current user token
     */
    public String getToken() {
        return token;
    }

    /**
     * Purge the current session data
     */
    public void purge() {
        cookie = null;
        token = null;
    }

}
