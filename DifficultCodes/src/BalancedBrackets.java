
public class BalancedBrackets {

	static char[] charStack;
    static int top;
    
	public static void main(String[] args) {
		//String[] braceStr = {"{}[]()", "{[}]", "[[[]]]{}(({}))","{{{{{}"};
		//String[] braceStr = {"}][}}(}][))]", "[](){()}", "()", "({}([][]))[]()", "{)[](}]}]}))}(())("};
		String[] braceStr = {"[()][{}()][](){}([{}(())([[{}]])][])[]([][])(){}{{}{[](){}}}()[]({})[{}{{}([{}][])}]",
				"[()][{}[{}[{}]]][]{}[]{}[]{{}({}(){({{}{}[([[]][[]])()]})({}{{}})})}",
				"(])[{{{][)[)])(]){(}))[{(})][[{)(}){[(]})[[{}(])}({)(}[[()}{}}]{}{}}()}{({}](]{{[}}(([{]",
				"){[]()})}}]{}[}}})}{]{](]](()][{))])(}]}))(}[}{{)}{[[}[]",
				"}(]}){",
				"((]()(]([({]}({[)){}}[}({[{])(]{()[]}}{)}}]]{({)[}{(",
				"{}{({{}})}[][{{}}]{}{}(){{}[]}{}([[][{}]]())",
				"(){}[()[][]]{}(())()[[([])][()]{}{}(({}[]()))()[()[{()}]][]]",
				"()([]({}[]){}){}{()}[]{}[]()(()([[]]()))()()()[]()(){{}}()({[{}][]}[[{{}({({({})})})}]])",
				"[]([{][][)(])}()([}[}(})}])}))]](}{}})[]({{}}))[])(}}[[{]{}]()[(][])}({]{}[[))[[}[}{(]})()){{(]]){][",
				"{()({}[[{}]]()(){[{{}{[[{}]{}((({[]}{}()[])))]((()()))}(()[[[]]])((()[[](({([])()}))[]]))}]})}",
				"()(){{}}[()()]{}{}",
				"{}()([[]])({}){({[][[][[()]]{{}[[]()]}]})}[](())((())[{{}}])",
				"{}(((){}){[]{{()()}}()})[]{{()}{(){()(){}}}}{()}({()(()({}{}()((()((([])){[][{()}{}]})))))})",
				"][[{)())))}[)}}}}[{){}()]([][]){{{{{[)}]]{([{)()][({}[){]({{",
				"{{}(",
				"{[{((({}{({({()})()})[]({()[[][][]]}){}}))){}}]}{}{({((){{}[][]{}[][]{}}[{}])(())}[][])}",
				"()[[][()[]][]()](([[[(){()[[]](([]))}]]]))",
				"()[]({}{})(()){{{}}()()}({[]()}())[](){}(({()}[{}[{({{}}){({}){({})((({()})))}}}]]))",
				"}[{){({}({)})]([}{[}}{[(([])[(}){[]])([]]}(]]]]{][",
				"[{]{[{(){[}{}(([(]}])(){[[}(]){(})))}}{{)}}{}][({(}))]}({)",
				")})[(]{][[())]{[]{{}}[)[)}[]){}](}({](}}}[}{({()]]",
				"[[[({[]}({[][[[[][[{(()[][])}()[][]][]{}]]]]}))][(()){}]]]()[{}([]{}){}{{}}]",
				"({[]({[]})}())[][{}[{{(({{{([{}])}}}))}}]]",
				"([((()))()])[][][]{}()(([]))[]()[]((){}[]){}(){{}[]}[[{[]}]]",
				"[[(((({}{[]{}()}){}{{}}){({[]{[{}]{(){}(((){()}))}()}}[[]]()()[()])[[{}{}]()]}))]]{}[]{}({({{}})})",
				"(]{()}((",
				"[][(())[({{{()[]}}{[[][[][[[]{{{[()]{{{{}{[]}[][]}}}}}}]]]]}})]]",
				"}[})})}[)]{}{)",
				"({(}{})))}(}[)[}{)}}[)[{][{(}{{}]({}{[(})[{[({{[}{(]]})}",
				"]}})[]))]{][])[}(])]({[]}[]([)",
				"[{{}{[{{[}[[}([]",
				"[([]){}][({})({[(([])[][])][[{}{([{{}{(()){{{({}{{}}())}}[]}}()[()[{{{([](()){[[[]]]})}}}]]}])}]]})]",
				"]{}{(}))}](})[{]]()(]([}]([}][}{]{[])}{{{]([][()){{})[{({{{[}{}](]}}",
				"{[{}}){(}[][)(}[}][)({[[{]}[(()[}}){}{)([)]}(()))]{)(}}}][",
				"(]{}{(}}}[)[",
				"[]{}{[[]]}([{}]{}[]){{(())}}",
				"[)([{(][(){)[)}{)]]}}([((][[}}(]{}]]}]][(({{{))[[){}{]][))[]{]][)[{{}{()]){)])))){{{[(]}[}}{}]",
				"{({(){[[[][]{}[[([]{})]{}]][[]()()]]}})}[{}{{}}]",
				")}][(})){))[{}[}",
				"{[]{({]}[}}[{([([)([){{}{(}}[]}}[[{[}[[()(])[}[]",
				"()()()[]",
				"((){}])][]][}{]{)]]}][{]}[)(])[}[({(",
				")[((])(]]]]((]){{{{())]}]}(}{([}(({}]])[[{){[}]{{}})[){(",
				"}][[{[((}{[]){}}[[[)({[)}]]}(]]{[)[]}{}(){}}][{()]))})]][(((}}",
				"([]){}{{}{}}()([([{}{[[]()([(([]()))()[[]]])]}])])",
				"[()[[]{{[]}()([])}[]][][]][]()[]{}{}[][]{}{}[()(){}]",
				"{[{){]({(((({](]{([])([{{([])[}(){(]](]{[{[]}}())[){})}))[{})))[",
				"{}[()[]][]{}{}[[{{[[({})]()[[()]]]}}]]",
				"{[{}[][]]}[((()))][]({})[]{}{()}",
				"(){[{({})}]}",
				"([]])][{)]({)[]))}]())[}]))][}{(}}})){]}]{[)}(][})[[",
				"((({{}(([{}(())]))[()]{[[[]()]]}})))",
				"}()))}(}]]{{})}][{](]][{]{[[]]]}]]}([)({([))[[(]}])}[}(([{)[)]]([[](]}]}{]{{})[]){]}{])(",
				"{}{}{}{[[()]][]}",
				")]}]({{})[[[{]{{{}}][))]{{",
				"))){({}])}])}}]{)()(}(]}([",
				"([[]][])[[]()][]()(([[]]{[()[]{[][{}]}[()]]{}{[]}}{{}()}(()[([][]{})[[{}][]]{}[]])))",
				"(]{[({}[){)))}]{[{}][({[({[]))}[}]}{()(([]{]()}})}[]{[)](((]]])([]}}]){)(([]]}[[}[",
				"([[]])({}(([(){{}[{}]}]){[{}]}))[][{}{}](){}",
				"[][][][][][([])][]{({()}[[()()]{([(){[]{}}{(())}{[](){}()({}())}[({}[[]()])][]])}])}",
				"}[{{(}})}}(((())()({]{([]((][(({)[({[]]}[])}]{][{{}]{)][}(])}}}))}}}",
				"[]({})()[]{}{}[]({}{})[]{([])()[()][{()({})[{}{[[()]{}[]][]}(({{[]{()()()}{}[]()}[]}){{}{}})]}]}",
				"{{(([{)]{}({][{](){({([[[][)}[)})(",
				"[{}]{[()({[{}]})]}",
				"[[{}]]",
				"]{{({[{]}[[)]]}{}))}{){({]]}{]([)({{[]){)]{}){){}()})(]]{{])(])[]}][[()()}",
				"{[([}[[{{(]]][}()())]{){(){)]]){})}]{][][(}[]())[}[)})})[][{[)[})()][]))}[[}",
				"]()])}[}}}{]]{)[}(}]]])])}{(}{([{]({)]}])(})[{}[)]])]}[]{{)){}{()}]}((}}{({])[}])[]}",
				"(]}[{}{{][}))){{{([)([[])([]{[",
				"{(()[]){}}(){[]}({{}(()())})([]){}{}(())()[()]{}()",
				"{{}[{}[{}[]]]}{}({{[]}})[[(){}][]]{}(([]{[][]()()}{{{()()}{[]}({}[]{()})}{()}[[]][()]}))",
				"{[][]}[{}[](){}]{{}{[][{}]}}",
				"()(){}(){((){}[])([[]]())}",
				"{}[[{[((}[(}[[]{{]([(}]][[",
				"{}[([{[{{}()}]{}}([[{}[]]({}{{()}[][][]})])])]",
				"{[](}([)(])[]]})()]){[({]}{{{)({}(][{{[}}(]{",
				"[][]{{}[](())}{}({[()]}())[][[][({}([{}]))]]",
				"((()))[]{[(()({[()({[]}{})]}))]}{[]}{{({}{})[{}{}]{()([()])[{()}()[[]{}()]{}{}[]()]}[[]{[]}([])]}}"};
		String[] result = braces(braceStr);
		for(int i=0; i<result.length; i++){
			System.out.println(" " + result[i]);
		}
	}
	
    static String[] braces(String[] values) {
        String[] result = new String[values.length];
        for(int i=0; i<values.length; i++){
            char[] chars = values[i].toCharArray();
            charStack = new char[values[i].length()];
            top = -1;
            int length = 0;
            while(length < chars.length && !"NO".equalsIgnoreCase(result[i])){
            	char ch = chars[length];
            	length++;
                switch(ch){
		            case '{':
		            case '(':
		            case '[':
		                push(ch);
		                break;
		            case '}':
		            if('{' == pop()){
		                result[i] = "YES";
		            }else{
		                result[i] = "NO";
		            }
		            break;                        
		            case ')':
		            if('(' == pop()){
		                result[i] = "YES";
		            }else{
		                result[i] = "NO";    
		            }
		            break;                    
		            case ']':
		            if('[' == pop()){
		                result[i] = "YES";
		            }else{
		                result[i] = "NO";    
		            }
		            break;
		            default:
		            	result[i] = "NO";
		                break;
		            }
                }
            if(length == chars.length && top != -1){
            	result[i] = "NO";
            }
            }
        return result;
    }

    static void push(char val){
        charStack[++top] = val;
    }

    static char pop(){
    	
    	if(top != -1){
    		return charStack[top--];
    	}
       return 0; 
    }

}
