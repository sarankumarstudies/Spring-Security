package com.sstudies.saranbank.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
@RequiredArgsConstructor
public class SaranBankProdUserNamePasswordAuthenticationProvider implements AuthenticationProvider {

    /*
    DAOAuthenticationProvider is the default one.
    This is the alternative class which will handle the custom Authentication

     */



    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    /**
     * @param authentication the authentication request object.
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password =  authentication.getCredentials().toString();
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        if (passwordEncoder.matches(password, userDetails.getPassword())){
            // perform validation, custom validation we can write over here :)

            return new UsernamePasswordAuthenticationToken(userName, password ,userDetails.getAuthorities());

        }else {
            throw new BadCredentialsException("Invalid password!");
        }

    }

    /**
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
