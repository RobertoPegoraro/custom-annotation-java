@Bean
public void replaceEndpoint() throws IllegalAccessException {

    Reflections reflections = new Reflections("com.myproject", new FieldAnnotationsScanner());

    Set<Field> fieldsAnnotatedWith = reflections.getFieldsAnnotatedWith(Endpoint.class);

    for (Field f : fieldsAnnotatedWith) {
        Annotation[] annotations = f.getAnnotations();
        for (Annotation a : annotations) {
            if (a instanceof Endpoint) {
                if (((Endpoint) a).type().equals(Type.EDGE)) {
                    f.set(String.class, myProperties().getHostEdge().concat(((Endpoint) a).value()));
                } else if (((Endpoint) a).type().equals(Type.SERVER)) {
                    f.set(String.class, myProperties().getHostServer().concat(((Endpoint) a).value()));
                }
            }
        }
    }
}
