//
//  ReactNativeUITests.swift
//  ReactNativeUITests
//
//  Created by Felipe Costa on 26/03/20.
//  Copyright © 2020 Facebook. All rights reserved.
//

import XCTest
import SwiftMonkey

class ReactNativeUITests: XCTestCase {

    func testMonkey() {
            let application = XCUIApplication()
            application.launch()
            
            let monkey = Monkey(frame: application.frame)
            monkey.addDefaultXCTestPublicActions(app: application)
            monkey.addXCTestTapAlertAction(interval: 100, application: application)
            monkey.monkeyAround()
    }
}
