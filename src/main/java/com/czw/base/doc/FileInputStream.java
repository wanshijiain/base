package com.czw.base.doc;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.net.URI;
import java.security.KeyStore;
import java.security.KeyStore.ProtectionParameter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/** 
 * copy JDK sources comments and use javac to look the effect
 * 
 * @author Zevi Chan
 * @date 2016-6-14 17:18:42 
 * 
 */
public class FileInputStream {
	
	/**
     * Creates a <code>FileInputStream</code> by
     * opening a connection to an actual file,
     * the file named by the path name <code>name</code>
     * in the file system.  A new <code>FileDescriptor</code>
     * object is created to represent this file
     * connection.
     * <p>
     * First, if there is a security
     * manager, its <code>checkRead</code> method
     * is called with the <code>name</code> argument
     * as its argument.
     * <p>
     * If the named file does not exist, is a directory rather than a regular
     * file, or for some other reason cannot be opened for reading then a
     * <code>FileNotFoundException</code> is thrown.
     *
     * @param      name   the system-dependent file name.
     * @exception  FileNotFoundException  if the file does not exist,
     *                   is a directory rather than a regular file,
     *                   or for some other reason cannot be opened for
     *                   reading.
     * @exception  SecurityException      if a security manager exists and its
     *               <code>checkRead</code> method denies read access
     *               to the file.
     * @see        java.lang.SecurityManager#checkRead(java.lang.String)
     */
    public FileInputStream(String name) throws FileNotFoundException {
    }

    /**
     * Creates a <code>FileInputStream</code> by
     * opening a connection to an actual file,
     * the file named by the <code>File</code>
     * object <code>file</code> in the file system.
     * A new <code>FileDescriptor</code> object
     * is created to represent this file connection.
     * <p>
     * First, if there is a security manager,
     * its <code>checkRead</code> method  is called
     * with the path represented by the <code>file</code>
     * argument as its argument.
     * <p>
     * If the named file does not exist, is a directory rather than a regular
     * file, or for some other reason cannot be opened for reading then a
     * <code>FileNotFoundException</code> is thrown.
     *
     * @param      file   the file to be opened for reading.
     * @exception  FileNotFoundException  if the file does not exist,
     *                   is a directory rather than a regular file,
     *                   or for some other reason cannot be opened for
     *                   reading.
     * @exception  SecurityException      if a security manager exists and its
     *               <code>checkRead</code> method denies read access to the file.
     * @see        java.io.File#getPath()
     * @see        java.lang.SecurityManager#checkRead(java.lang.String)
     */
    public FileInputStream(File file) throws FileNotFoundException {
    }
    
    
    
    /**
     * Constructs a DomainLoadStoreParameter for a keystore domain with
     * the parameters used to protect keystore data.[this is a method that
     * i changed]
     *
     * @param configuration identifier for the domain configuration data.
     *     The name of the target domain should be specified in the
     *     {@code java.net.URI} fragment component when it is necessary
     *     to distinguish between several domain configurations at the
     *     same location.
     *
     * @param protectionParams the map from keystore name to the parameter
     *     used to protect keystore data.
     *     A {@code java.util.Collections.EMPTY_MAP} should be used
     *     when protection parameters are not required or when they have
     *     been specified by properties in the domain configuration data.
     *     It is cloned to prevent subsequent modification.
     *
     * @exception NullPointerException if {@code configuration} or
     *     {@code protectionParams} is {@code null}
     */
    public void DomainLoadStoreParameter(URI configuration){
    }
    
    
    /**
     * A marker interface for {@code KeyStore}
     * {@link #load(KeyStore.LoadStoreParameter) load}
     * and
     * {@link #store(KeyStore.LoadStoreParameter) store}
     * parameters.
     *
     * @since 1.5
     */
    public static interface LoadStoreParameter {
        /**
         * Gets the parameter used to protect keystore data.
         *
         * @return the parameter used to protect keystore data, or null
         */
        public ProtectionParameter getProtectionParameter();
    }
    
    
}
