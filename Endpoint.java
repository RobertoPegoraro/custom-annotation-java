@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Endpoint {

    Endpoint.Type type();

    String value();
    
    public static enum Type {

	EDGE,
        SERVER;
        
        private Type() { }
    }
}
