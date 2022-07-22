package org.glaz.network.integration.service;

import lombok.RequiredArgsConstructor;
import org.glaz.network.integration.IntegrationTestBase;
import org.glaz.network.service.UserService;

@RequiredArgsConstructor
public class UserServiceIT extends IntegrationTestBase {

    private final UserService userService;
}
