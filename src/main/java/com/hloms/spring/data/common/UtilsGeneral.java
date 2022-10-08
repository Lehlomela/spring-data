package com.hloms.spring.data.common;

import com.hloms.spring.data.BasicQueryMethods;
import com.hloms.spring.data.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UtilsGeneral {

  public static final Logger log = LoggerFactory.getLogger(BasicQueryMethods.class);

  public static void logInfo(final String msg) {
    log.info(msg);
    log.info("--------------------------------------------");
  }

  public static <T> void logObject(T object) {
    log.info(object + "");
  }

}
