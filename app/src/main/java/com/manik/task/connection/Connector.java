package com.manik.task.connection;

/**
 * @author Ravishankar
 * @version 1.0
 * @since 14-04-2017
 */

import java.util.Map;

public interface Connector {
     void setPostParams(Map<String, String> postParams);
     void setHeaderParams(Map<String, String> postParams);

     void connect();
     void parseJson(String response);
}
