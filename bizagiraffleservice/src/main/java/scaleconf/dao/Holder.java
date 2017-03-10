package scaleconf.dao;

/**
 * Created by dev-camiloh on 3/7/17.
 */
public class Holder {

    private String name;
    private String email;
    private String profileUrl;
    private String documentUrl;

    public Holder(String name,String email, String profileUrl, String documentUrl) {
        this.name = name;
        this.email=email;
        this.profileUrl = profileUrl;
        this.documentUrl = documentUrl;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }
}
