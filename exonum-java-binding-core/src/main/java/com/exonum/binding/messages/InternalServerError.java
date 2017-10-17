package com.exonum.binding.messages;

/**
 * Indicates that an internal error occurred during transaction processing.
 */
public class InternalServerError extends Exception {

  InternalServerError(String message) {
    super(message);
  }
}