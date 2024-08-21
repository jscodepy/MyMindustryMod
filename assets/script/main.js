if(false && Version.number > 6 && !Vars.headless) {
    print("Setting up 7.0 compatibility JS...");

    function mfItems(name) {
        return Vars.content.getByName(ContentType.item,"morefactories-"+name);
    }

}