package ca.cmpt213.as4.model.linestylers;

import ca.cmpt213.as4.model.FlexBox;
import ca.cmpt213.as4.model.Coord;

public class SequenceLineStyler implements LineStyler{
//    https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html
//0x     1140: ᅀ ᅁ ᅂ ᅃ ᅄ ᅅ ᅆ ᅇ ᅈ ᅉ ᅊ ᅋ ᅌ ᅍ ᅎ ᅏ ᅐ ᅑ ᅒ ᅓ ᅔ ᅕ ᅖ ᅗ ᅘ ᅙ ᅚ ᅛ ᅜ ᅝ ᅞ ᅟ ᅠ ᅡ ᅢ ᅣ ᅤ ᅥ ᅦ ᅧ ᅨ ᅩ ᅪ ᅫ ᅬ ᅭ ᅮ ᅯ ᅰ ᅱ ᅲ ᅳ ᅴ ᅵ ᅶ ᅷ ᅸ ᅹ ᅺ ᅻ ᅼ ᅽ ᅾ ᅿ
//0x     1180: ᆀ ᆁ ᆂ ᆃ ᆄ ᆅ ᆆ ᆇ ᆈ ᆉ ᆊ ᆋ ᆌ ᆍ ᆎ ᆏ ᆐ ᆑ ᆒ ᆓ ᆔ ᆕ ᆖ ᆗ ᆘ ᆙ ᆚ ᆛ ᆜ ᆝ ᆞ ᆟ ᆠ ᆡ ᆢ ᆣ ᆤ ᆥ ᆦ ᆧ ᆨ ᆩ ᆪ ᆫ ᆬ ᆭ ᆮ ᆯ ᆰ ᆱ ᆲ ᆳ ᆴ ᆵ ᆶ ᆷ ᆸ ᆹ ᆺ ᆻ ᆼ ᆽ ᆾ ᆿ


//0x     2500: ─ ━ │ ┃ ┄ ┅ ┆ ┇ ┈ ┉ ┊ ┋ ┌ ┍ ┎ ┏ ┐ ┑ ┒ ┓ └ ┕ ┖ ┗ ┘ ┙ ┚ ┛ ├ ┝ ┞ ┟ ┠ ┡ ┢ ┣ ┤ ┥ ┦ ┧ ┨ ┩ ┪ ┫ ┬ ┭ ┮ ┯ ┰ ┱ ┲ ┳ ┴ ┵ ┶ ┷ ┸ ┹ ┺ ┻ ┼ ┽ ┾ ┿
//0x     2540: ╀ ╁ ╂ ╃ ╄ ╅ ╆ ╇ ╈ ╉ ╊ ╋ ╌ ╍ ╎ ╏ ═ ║ ╒ ╓ ╔ ╕ ╖ ╗ ╘ ╙ ╚ ╛ ╜ ╝ ╞ ╟ ╠ ╡ ╢ ╣ ╤ ╥ ╦ ╧ ╨ ╩ ╪ ╫ ╬ ╭ ╮ ╯ ╰ ╱ ╲ ╳ ╴ ╵ ╶ ╷ ╸ ╹ ╺ ╻ ╼ ╽ ╾ ╿
//0x     2580: ▀ ▁ ▂ ▃ ▄ ▅ ▆ ▇ █ ▉ ▊ ▋ ▌ ▍ ▎ ▏ ▐ ░ ▒ ▓ ▔ ▕ ▖ ▗ ▘ ▙ ▚ ▛ ▜ ▝ ▞ ▟ ■ □ ▢ ▣ ▤ ▥ ▦ ▧ ▨ ▩ ▪ ▫ ▬ ▭ ▮ ▯ ▰ ▱ ▲ △ ▴ ▵ ▶ ▷ ▸ ▹ ► ▻ ▼ ▽ ▾ ▿
//0x     25c0: ◀ ◁ ◂ ◃ ◄ ◅ ◆ ◇ ◈ ◉ ◊ ○ ◌ ◍ ◎ ● ◐ ◑ ◒ ◓ ◔ ◕ ◖ ◗ ◘ ◙ ◚ ◛ ◜ ◝ ◞ ◟ ◠ ◡ ◢ ◣ ◤ ◥ ◦ ◧ ◨ ◩ ◪ ◫ ◬ ◭ ◮ ◯ ◰ ◱ ◲ ◳ ◴ ◵ ◶ ◷ ◸ ◹ ◺ ◻ ◼ ◽ ◾ ◿
//0x     2600: ☀ ☁ ☂ ☃ ☄ ★ ☆ ☇ ☈ ☉ ☊ ☋ ☌ ☍ ☎ ☏ ☐ ☑ ☒ ☓ ☔ ☕ ☖ ☗ ☘ ☙ ☚ ☛ ☜ ☝ ☞ ☟ ☠ ☡ ☢ ☣ ☤ ☥ ☦ ☧ ☨ ☩ ☪ ☫ ☬ ☭ ☮ ☯ ☰ ☱ ☲ ☳ ☴ ☵ ☶ ☷ ☸ ☹ ☺ ☻ ☼ ☽ ☾ ☿
//0x     2640: ♀ ♁ ♂ ♃ ♄ ♅ ♆ ♇ ♈ ♉ ♊ ♋ ♌ ♍ ♎ ♏ ♐ ♑ ♒ ♓ ♔ ♕ ♖ ♗ ♘ ♙ ♚ ♛ ♜ ♝ ♞ ♟ ♠ ♡ ♢ ♣ ♤ ♥ ♦ ♧ ♨ ♩ ♪ ♫ ♬ ♭ ♮ ♯ ♰ ♱ ♲ ♳ ♴ ♵ ♶ ♷ ♸ ♹ ♺ ♻ ♼ ♽ ♾ ♿
//0x     2b00: ⬀ ⬁ ⬂ ⬃ ⬄ ⬅ ⬆ ⬇ ⬈ ⬉ ⬊ ⬋ ⬌ ⬍ ⬎ ⬏ ⬐ ⬑ ⬒ ⬓ ⬔ ⬕ ⬖ ⬗ ⬘ ⬙ ⬚ ⬛ ⬜ ⬝ ⬞ ⬟ ⬠ ⬡ ⬢ ⬣ ⬤ ⬥ ⬦ ⬧ ⬨ ⬩ ⬪ ⬫ ⬬ ⬭ ⬮ ⬯ ⬰ ⬱ ⬲ ⬳ ⬴ ⬵ ⬶ ⬷ ⬸ ⬹ ⬺ ⬻ ⬼ ⬽ ⬾ ⬿
//0x     2b40: ⭀ ⭁ ⭂ ⭃ ⭄ ⭅ ⭆ ⭇ ⭈ ⭉ ⭊ ⭋ ⭌ ⭍ ⭎ ⭏ ⭐ ⭑ ⭒ ⭓ ⭔ ⭕ ⭖ ⭗ ⭘ ⭙ ⭚ ⭛ ⭜ ⭝ ⭞ ⭟ ⭠ ⭡ ⭢ ⭣ ⭤ ⭥ ⭦ ⭧ ⭨ ⭩ ⭪ ⭫ ⭬ ⭭ ⭮ ⭯ ⭰ ⭱ ⭲ ⭳ ⭴ ⭵ ⭶ ⭷ ⭸ ⭹ ⭺ ⭻ ⭼ ⭽ ⭾ ⭿
//0x     2b80: ⮀ ⮁ ⮂ ⮃ ⮄ ⮅ ⮆ ⮇ ⮈ ⮉ ⮊ ⮋ ⮌ ⮍ ⮎ ⮏ ⮐ ⮑ ⮒ ⮓ ⮔ ⮕ ⮖ ⮗ ⮘ ⮙ ⮚ ⮛ ⮜ ⮝ ⮞ ⮟ ⮠ ⮡ ⮢ ⮣ ⮤ ⮥ ⮦ ⮧ ⮨ ⮩ ⮪ ⮫ ⮬ ⮭ ⮮ ⮯ ⮰ ⮱ ⮲ ⮳ ⮴ ⮵ ⮶ ⮷ ⮸ ⮹ ⮺ ⮻ ⮼ ⮽ ⮾ ⮿
//0x     2bc0: ⯀ ⯁ ⯂ ⯃ ⯄ ⯅ ⯆ ⯇ ⯈ ⯉ ⯊ ⯋ ⯌ ⯍ ⯎ ⯏ ⯐ ⯑ ⯒ ⯓ ⯔ ⯕ ⯖ ⯗ ⯘ ⯙ ⯚ ⯛ ⯜ ⯝ ⯞ ⯟ ⯠ ⯡ ⯢ ⯣ ⯤ ⯥ ⯦ ⯧ ⯨ ⯩ ⯪ ⯫ ⯬ ⯭ ⯮ ⯯ ⯰ ⯱ ⯲ ⯳ ⯴ ⯵ ⯶ ⯷ ⯸ ⯹ ⯺ ⯻ ⯼ ⯽ ⯾ ⯿
//0x     a640: Ꙁ ꙁ Ꙃ ꙃ Ꙅ ꙅ Ꙇ ꙇ Ꙉ ꙉ Ꙋ ꙋ Ꙍ ꙍ Ꙏ ꙏ Ꙑ ꙑ Ꙓ ꙓ Ꙕ ꙕ Ꙗ ꙗ Ꙙ ꙙ Ꙛ ꙛ Ꙝ ꙝ Ꙟ ꙟ Ꙡ ꙡ Ꙣ ꙣ Ꙥ ꙥ Ꙧ ꙧ Ꙩ ꙩ Ꙫ ꙫ Ꙭ ꙭ ꙮ ꙯ ꙰ ꙱ ꙲ ꙳ ꙴ ꙵ ꙶ ꙷ ꙸ ꙹ ꙺ ꙻ ꙼ ꙽ ꙾ ꙿ
//0x     a740: Ꝁ ꝁ Ꝃ ꝃ Ꝅ ꝅ Ꝇ ꝇ Ꝉ ꝉ Ꝋ ꝋ Ꝍ ꝍ Ꝏ ꝏ Ꝑ ꝑ Ꝓ ꝓ Ꝕ ꝕ Ꝗ ꝗ Ꝙ ꝙ Ꝛ ꝛ Ꝝ ꝝ Ꝟ ꝟ Ꝡ ꝡ Ꝣ ꝣ Ꝥ ꝥ Ꝧ ꝧ Ꝩ ꝩ Ꝫ ꝫ Ꝭ ꝭ Ꝯ ꝯ ꝰ ꝱ ꝲ ꝳ ꝴ ꝵ ꝶ ꝷ ꝸ Ꝺ ꝺ Ꝼ ꝼ Ᵹ Ꝿ ꝿ
//   ꙫ ꙭ Ꙭ Ꝏ Ꙭ ꙭ ꙫ
    //0x     f0c0: ...                  
//0x     e480: ...                  
    //private final char[] notes = new char[]{'♯', '-', '=', '\\'};
//    private final char[] notes = new char[]{'♩', '♪', '♫', '♬'};
//    private final char[] notes = new char[]{'','','','','','','',''};
//    private final char[] notes = new char[]{'a', 'b', 'c', 'd', 'e'};
    private final char[] notes = new char[]{'1', '2', '3', '4', '5'};

    @Override
    public char getLineStyleAt(Coord coord, FlexBox b) {
        assert b.isBorder(coord);

        int top = b.getTopLeft().getY();
        int right = b.getBottomRight().getX();
        int bottom = b.getBottomRight().getY();
        int left = b.getTopLeft().getX();

        int width = right - left + 1;
        int height = bottom - top + 1;

        int idx = 0;
        // On top?
        if (coord.getY() == top) {
            idx += coord.getX() - left;
        } else {
            idx += width - 1;

            // On right?
            if (coord.getX() == right) {
                idx += coord.getY() - top;
            } else {
                idx += height - 1;

                // On Bottom?
                if (coord.getY() == bottom) {
                    idx += right - coord.getX();
                } else {
                    idx += width - 1;

                    // Left!
                    idx += bottom - coord.getY();
                }
            }
        }

        return notes[idx % notes.length];
    }
}
