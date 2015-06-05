manager.addShortText("  ", "white", "white", "0px", "white")
def matcher = manager.getLogMatcher(".*BUILD BREAKER.(.*) since.*\$")
if(matcher != null){
    manager.addShortText(matcher.group(1))
}

