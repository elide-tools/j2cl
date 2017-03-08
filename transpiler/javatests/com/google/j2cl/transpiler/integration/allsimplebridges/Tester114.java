package com.google.j2cl.transpiler.integration.allsimplebridges;

import jsinterop.annotations.JsType;

public class Tester114 {
  static interface I1 {
    default String get(String value) {
      return "I1.get";
    }
  }

  @JsType
  static class C1<T> {
    C1() {}
    public String get(T value) {
      return "C1.get";
    }
  }

  @SuppressWarnings("unchecked")
  static class C2 extends C1<String> implements I1 {
    C2() {}
  }

  @SuppressWarnings("unchecked")
  public static void test() {
    C2 s = new C2();
    assert ((C1) s).get("").equals("C1.get");
    assert ((I1) s).get("").equals("C1.get");
  }
}
