/*
 *  Copyright (c) 2005-2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.wso2.carbon.samples.webapp.internal;

import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.webapp.WebAppContext;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Dictionary;
import java.util.Hashtable;

public class Activator implements BundleActivator {
    private final static Logger logger = LoggerFactory.getLogger(Activator.class);

    @Override
    public void start(BundleContext bundleContext) throws Exception {

        WebAppContext webapp = new WebAppContext();
        Dictionary<String, String> props = new Hashtable<>();
        props.put("Jetty-WarFolderPath", ".");
        props.put("managedServerName", "carbon-server");
        props.put("contextPath", "/bundle");
        bundleContext.registerService(ContextHandler.class.getName(), webapp, props);
        logger.info("Deploying sample bundle as a webapp : /bundle");

    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }
}
