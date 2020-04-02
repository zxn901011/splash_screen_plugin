import 'dart:async';

import 'package:flutter/services.dart';

class SplashScreenPlugin {
  static const MethodChannel _channel =
  const MethodChannel('splash_screen_plugin');

  ///hide splash screen
  static Future<Null> hide() async {
    await _channel.invokeMethod('hide');
  }
}
