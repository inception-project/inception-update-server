/*
 * Copyright 2019
 * Ubiquitous Knowledge Processing (UKP) Lab and FG Language Technology
 * Technische Universität Darmstadt
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.tudarmstadt.ukp.inception.pluginserver.ui.core.menu;

import org.apache.wicket.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.tudarmstadt.ukp.clarin.webanno.security.UserDao;
import de.tudarmstadt.ukp.clarin.webanno.ui.core.menu.MenuItem;
import de.tudarmstadt.ukp.inception.pluginserver.ui.core.pluginmanager.AdminPluginManagerPage;

/**
 * This menu item on the usadminer dashboard links to the AdminPluginManagerPage.
 */
@Component
public class AdminPluginMgrMenuItem implements MenuItem
{

    private @Autowired UserDao userRepository;

    @Override
    public String getPath()
    {
        return "/admin/plugingmr";
    }

    @Override
    public String getIcon()
    {
        return "images/pluginmgr_admin.png";
    }

    @Override
    public String getLabel()
    {
        return "All Plugins";
    }

    @Override
    public Class<? extends Page> getPageClass()
    {
        return AdminPluginManagerPage.class;
    }

    @Override
    public boolean applies()
    {
        return userRepository.isAdministrator(userRepository.getCurrentUser());
    }

}
