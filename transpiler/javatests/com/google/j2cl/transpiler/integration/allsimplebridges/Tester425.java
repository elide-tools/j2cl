package com.google.j2cl.transpiler.integration.allsimplebridges;

import jsinterop.annotations.JsType;

public class Tester425 {
  @JsType
  abstract static class C1 {
    C1() {}
    public abstract String get(Object value);
  }

  @SuppressWarnings("unchecked")
  static class C2 extends C1 {
    C2() {}
    @SuppressWarnings("MissingOverride")
    public String get(Object value) {
      return "C2.get";
    }
  }

  @SuppressWarnings("unchecked")
  public static void test() {
    C2 s = new C2();
    assert s.get(new Object()).equals("C2.get");
    assert ((C1) s).get("").equals("C2.get");
  }
}
