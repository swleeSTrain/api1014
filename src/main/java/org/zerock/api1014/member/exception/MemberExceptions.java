package org.zerock.api1014.member.exception;

public enum MemberExceptions {

    BAD_AUTH(400,"ID/PW incorrect 틀림");

    private MemberTaskException exception;

    MemberExceptions(int status, String msg) {
        exception = new MemberTaskException(status, msg);
    }

    public MemberTaskException get() {
        return exception;
    }

}
