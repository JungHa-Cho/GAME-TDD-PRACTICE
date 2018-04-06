package kr.personal.cjh.tdd.practice.wordwrap;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WordWrap {
    /**
     * getting Stuck.
     * most degenerate test case를 먼저 작성하지 않았다.
     * 아주 단순한, 공백, 스페이스, null 부터 작성해야 하지만.
     * 관심 있는 것 부터 작성해서 그렇다.
     */
    @Test
    public void notthing() {
//        assertThat(wrap("word word", 4), is("word\nword"));
//        assertThat(wrap("a dog", 5), is("a dog"));
//        assertThat(wrap("a dog with a bone", 6), is("a dog\nwidth a\nbone"));

        // 다시 시작함
        // 제일 쉬운 케이스, 스트링이면 null과 공백부터 테스트
        assertWraps(null, 1, "");
        assertWraps("", 1, "");
        assertWraps("x", 1, "x");
        assertWraps("xx", 1, "x\nx");
        assertWraps("xxx", 1, "x\nx\nx");
        assertWraps("x x", 1, "x\nx");
        assertWraps("x xx", 3, "x\nxx");
        assertWraps("four score and seven years ago our fathers brought forth upon this continent", 7,
                "four\nscore\nand\nseven\nyears\nago our\nfathers\nbrought\nforth\nupon\nthis\ncontine\nnt");
    }

    private void assertWraps(String s, int width, String expected) {
        assertThat(wrap(s, width), is(expected));
    }

    private String wrap(String s, int width) {
        if (s == null)
            return "";
        if (s.length() <= width)
            return s;
        else {
            int breakPoint = s.lastIndexOf(" ", width);
            if (breakPoint == -1)
                breakPoint = width;
            return s.substring(0, breakPoint) + "\n" + wrap(s.substring(breakPoint).trim(), width);
        }
    }
}
