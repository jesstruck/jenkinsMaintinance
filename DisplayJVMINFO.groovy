import net.bull.javamelody.*;

java = new JavaInformations(Parameters.getServletContext(), true);
println "\nsessions count:                 " + java.sessionCount;
println "\nactive HTTP threads count:      " + java.activeThreadCount;
println "\nthreads count:                  " + java.threadCount;
println "\nsystem load average:            " + java.systemLoadAverage;
println "\navailable processors:           " + java.availableProcessors;
println "\nhost:                           " + java.host;
println "\nos:                             " + java.os;
println "\njava version:                   " + java.javaVersion;
println "\njvm version:                    " + java.jvmVersion;
println "\npid:                            " + java.pid;
println "\nserver info:                    " + java.serverInfo;
println "\ncontext path:                   " + java.contextPath;
println "\nstart date:                     " + java.startDate;
