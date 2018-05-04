package com.example.jora.test.config;

public enum Version {
    H("3.0.0"),
    H_2("3.1.0"),
    H_3("3.2.0"),
    I_1_1("4.0.1"),
    I_1_2("4.0.2"),
    I_2_1("4.0.3"),
    I_2_2("4.0.4"),
    J("4.1"),
    J_2("4.2"),
    J_3("4.3"),
    K("4.4"),
    L("5.0"),
    L_2("5.1"),
    N("7.0"),
    N_2("7.1"),
    O("8.0.0"),
    O_2("8.1.0"),
    P("9.0.0");

    private String versionName;
    Version(String versionName) {
        this.versionName = versionName;
    }

    String getVersionName() {
        return versionName;
    }
}
