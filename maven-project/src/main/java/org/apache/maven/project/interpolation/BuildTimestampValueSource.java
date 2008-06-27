package org.apache.maven.project.interpolation;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.codehaus.plexus.interpolation.ValueSource;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @version $Id$
 */
public class BuildTimestampValueSource
    implements ValueSource
{

    private String formattedDate;

    public BuildTimestampValueSource( Date startTime, String format )
    {
        if ( startTime != null )
        {
            formattedDate = new SimpleDateFormat( format ).format( startTime );
        }
    }

    public Object getValue( String expression )
    {
        if ( "build.timestamp".equals( expression ) || "maven.build.timestamp".equals( expression ) )
        {
            return formattedDate;
        }

        return null;
    }

}
