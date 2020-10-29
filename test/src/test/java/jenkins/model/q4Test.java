/*
 * The MIT License
 *
 * Copyright (c) 2004-2011, Yahoo!, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package jenkins.model;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import hudson.maven.MavenModuleSet;
import hudson.maven.MavenModuleSetBuild;
import hudson.model.*;
import hudson.security.*;
import hudson.slaves.ComputerListener;
import hudson.slaves.DumbSlave;
import hudson.slaves.OfflineCause;
import hudson.util.FormValidation;
import hudson.util.HttpResponses;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.ExtractResourceSCM;
import org.jvnet.hudson.test.Issue;
import org.jvnet.hudson.test.JenkinsRule;
import org.jvnet.hudson.test.JenkinsRule.WebClient;
import org.jvnet.hudson.test.TestExtension;
import org.kohsuke.stapler.HttpResponse;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

/**
 * @author mythic forces (asrbadthebadderladthemasterofdisaster)
 *
 */
public class q4Test {

    @Rule public JenkinsRule j = new JenkinsRule();

    @Test
    public void testBadID () throws Exception {
        IdStrategy.CaseSensitive testID = new IdStrategy.CaseSensitive();
        assertEquals("oo",testID.idFromFilename("oo$00"));
    }

    @Test
    public void oofID () throws Exception {
        IdStrategy.CaseSensitive testID = new IdStrategy.CaseSensitive();
        assertEquals("oof",testID.idFromFilename("oo$0066"));
    }

    @Test
    public void oooID () throws Exception {
        IdStrategy.CaseSensitive testID = new IdStrategy.CaseSensitive();
        assertEquals("ooo",testID.idFromFilename("oo############o"));
    }

    @Test
    public void easyID () throws Exception {
        IdStrategy.CaseSensitive testID = new IdStrategy.CaseSensitive();
        assertEquals("abcd",testID.idFromFilename("abcd"));
    }

    @Test
    public void bigChungusID () throws Exception {
        IdStrategy.CaseSensitive testID = new IdStrategy.CaseSensitive();
        assertEquals("bigCHUNGUS",testID.idFromFilename("big~c~h~u~n~g~u~s"));
    }
}
