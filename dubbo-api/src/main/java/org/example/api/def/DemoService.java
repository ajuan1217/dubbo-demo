package org.example.api.def;

import org.example.api.model.User;

public interface DemoService {
    String sayHello(String name);

    User getUser(Long id);
}
