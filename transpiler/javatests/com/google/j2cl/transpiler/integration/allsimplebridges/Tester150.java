package com.google.j2cl.transpiler.integration.allsimplebridges;

public class Tester150 {
  static interface I1 {
    default String get(String value) {
      return "I1.get";
    }
  }

  static class C1<T> {
    C1() {}
    public String get(T value) {
      return "C1.get";
    }
  }

  @SuppressWarnings("unchecked")
  static class C2 extends C1 implements I1 {
    C2() {}
    @SuppressWarnings("MissingOverride")
    public String get(Object value) {
      return "C2.get";
    }

    @SuppressWarnings("MissingOverride")
    public String get(String value) {
      return "C2.get";
    }
  }

  @SuppressWarnings("unchecked")
  public static void test() {
    C2 s = new C2();
    assert s.get(new Object()).equals("C2.get");
    assert s.get("").equals("C2.get");
    assert ((C1) s).get("").equals("C2.get");
    assert ((I1) s).get("").equals("C2.get");
  }
}
