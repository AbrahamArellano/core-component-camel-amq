/**
 *  Copyright 2005-2015 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package org.redhat.fuse;

import java.io.InputStream;

import org.apache.camel.Exchange;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * To generate random orders
 */
@Component
public class OrderGenerator {

	private static final Logger LOG = Logger.getLogger(OrderGenerator.class);
    private static final String ORDER_ID = "orderId";
	private int count = 1;

    public InputStream generateOrder(Exchange exchange) {
        int number = exchange.getIn().getHeader(ORDER_ID, Integer.class);

        LOG.info("OrderGenerator - orderId: " + number);
    	
        String name = "data/order" + number + ".xml";

        return exchange.getContext().getClassResolver().loadResourceAsStream(name);
    }

    public String generateFileName() {
        return "order" + count++ + ".xml";
    }
}
