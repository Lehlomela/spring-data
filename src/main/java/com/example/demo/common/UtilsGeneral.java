package com.example.demo.common;

import com.example.demo.BasicQueryMethods;
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
}
