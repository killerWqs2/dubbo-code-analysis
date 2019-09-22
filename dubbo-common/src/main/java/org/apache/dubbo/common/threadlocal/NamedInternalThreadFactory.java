/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dubbo.common.threadlocal;

import org.apache.dubbo.common.utils.NamedThreadFactory;

/**
 * NamedInternalThreadFactory
 * This is a threadFactory which produce {@link InternalThread}
 */
public class NamedInternalThreadFactory extends NamedThreadFactory {

    public NamedInternalThreadFactory() {
        super();
    }

    public NamedInternalThreadFactory(String prefix) {
        super(prefix, false);
    }

    public NamedInternalThreadFactory(String prefix, boolean daemon) {
        super(prefix, daemon);
    }

    /**完全一样的复写*/
    @Override
    public Thread newThread(Runnable runnable) {
        String name = mPrefix + mThreadNum.getAndIncrement();

        InternalThread ret = new InternalThread(mGroup, runnable, name, 0);
        ret.setDaemon(mDaemon);
        return ret;
    }
}
