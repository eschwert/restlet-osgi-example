def run(cmd) {
  def ant = new AntBuilder()
  ant.sshexec(host:"localhost",
      trust: true,
      port: 8101,
      username: "smx",
      password: "smx",
      verbose: true,
      command:cmd)
}

run("start --force org.apache.felix.configadmin")
run("""config:propset -p org.ops4j.pax.url.mvn org.ops4j.pax.url.mvn.repositories "\
http://repo1.maven.org/maven2,\
http://repository.apache.org/content/groups/snapshots-group@snapshots@noreleases,\
http://svn.apache.org/repos/asf/servicemix/m2-repo,\
http://repository.springsource.com/maven/bundles/release,\
http://repository.springsource.com/maven/bundles/external,\
http://oss.sonatype.org/content/repositories/releases/,\
http://maven.restlet.org/\
"
""")
run("features:addurl mvn:net.sheenobu.osgi/restlet-osgi-example-features/0.1-snapshot/xml/features")
run("features:refreshurl mvn:net.sheenobu.osgi/restlet-osgi-example-features/0.1-snapshot/xml/features")
run("features:uninstall restlet-example");
run("features:install restlet-example")
