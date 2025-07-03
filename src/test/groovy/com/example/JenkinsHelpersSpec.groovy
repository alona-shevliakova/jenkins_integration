package com.example

import spock.lang.Specification

class JenkinsHelpersSpec extends Specification {
    def "filterId should extract digits"() {
        expect:
        JenkinsHelpers.filterId(input) == expected

        where:
        input         || expected
        'ABC-123'     || '123'
        'id_45-67x'   || '4567'
        ''            || ''
        null          || ''
    }

    def "getTaskId should extract task id from branch"() {
        expect:
        JenkinsHelpers.getTaskId(branch) == expected

        where:
        branch                              || expected
        'feature/TASK-123-add-tests'        || 'TASK-123'
        'hotfix/BUG-987'                    || 'BUG-987'
        'master'                            || ''
        null                                || ''
    }
}
