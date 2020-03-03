//
//  Memory.swift
//  NativePerfComparison
//
//  Created by Felipe Costa on 01/03/20.
//  Copyright © 2020 Felipe Costa. All rights reserved.
//

import Foundation

class Memory: NSObject {

    // From Quinn the Eskimo at Apple.
    // https://forums.developer.apple.com/thread/105088#357415

    class func memoryFootprint() -> Float? {
        // The `TASK_VM_INFO_COUNT` and `TASK_VM_INFO_REV1_COUNT` macros are too
        // complex for the Swift C importer, so we have to define them ourselves.
        let TASK_VM_INFO_COUNT = mach_msg_type_number_t(MemoryLayout<task_vm_info_data_t>.size / MemoryLayout<integer_t>.size)
        let TASK_VM_INFO_REV1_COUNT = mach_msg_type_number_t(MemoryLayout.offset(of: \task_vm_info_data_t.min_address)! / MemoryLayout<integer_t>.size)
        var info = task_vm_info_data_t()
        var count = TASK_VM_INFO_COUNT
        let kr = withUnsafeMutablePointer(to: &info) { infoPtr in
            infoPtr.withMemoryRebound(to: integer_t.self, capacity: Int(count)) { intPtr in
                task_info(mach_task_self_, task_flavor_t(TASK_VM_INFO), intPtr, &count)
            }
        }
        guard
            kr == KERN_SUCCESS,
            count >= TASK_VM_INFO_REV1_COUNT
            else { return nil }

        let usedBytes = Float(info.phys_footprint)
        return usedBytes
    }

    class func formattedMemoryFootprint() -> String
    {
        let usedBytes: UInt64? = UInt64(self.memoryFootprint() ?? 0)
        let usedMB = Double(usedBytes ?? 0) / 1024 / 1024
        let usedMBAsString: String = "\(usedMB) MB"
        return usedMBAsString
     }
}
