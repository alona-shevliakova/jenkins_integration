package com.example

class JenkinsHelpers {
    static String filterId(String id) {
        if (id == null) return ''
        return id.replaceAll(/[^0-9]/, '')
    }

    static String getTaskId(String branch) {
        if (branch == null) return ''
        def matcher = (branch =~ /([A-Z]+-\d+)/)
        return matcher.find() ? matcher.group(1) : ''
    }
}
