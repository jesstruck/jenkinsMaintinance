/**
Print's information about the Jenkins installation, mainly properties fron the main java process.
*/

import net.bull.javamelody.*;
java = new JavaInformations(Parameters.getServletContext(), true);
println "sessions count:                 " + java.sessionCount;
println "active HTTP threads count:      " + java.activeThreadCount;
println "threads count:                  " + java.threadCount;
println "system load average:            " + java.systemLoadAverage;
println "available processors:           " + java.availableProcessors;
println "host:                           " + java.host;
println "os:                             " + java.os;
println "java version:                   " + java.javaVersion;
println "jvm version:                    " + java.jvmVersion;
println "pid:                            " + java.pid;
println "server info:                    " + java.serverInfo;
println "context path:                   " + java.contextPath;
println "start date:                     " + java.startDate;
