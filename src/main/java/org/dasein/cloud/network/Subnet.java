/**
 * Copyright (C) 2009-2012 enStratus Networks Inc.
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */

package org.dasein.cloud.network;

import org.dasein.cloud.Taggable;

import javax.annotation.Nonnull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 2013.02 added Networkable interface
 */
public class Subnet implements Networkable, Taggable {
    private int         availableIpAddresses;
    private String      cidr;
    private SubnetState currentState;
    private String      description;
    private String      name;
    private String      providerDataCenterId;
    private String      providerOwnerId;
    private String      providerRegionId;
    private String      providerSubnetId;
    private String      providerVlanId;
    private IPVersion[] supportedTraffic;
    private Map<String,String> tags;
    
    public Subnet() { }

    public boolean equals(Object ob) {
        if( ob == null ) {
            return false;
        }
        if( ob == this ) {
            return true;
        }
        if( !getClass().getName().equals(ob.getClass().getName()) ) {
            return false;
        }
        Subnet other = (Subnet)ob;
        if( !providerSubnetId.equals(other.providerSubnetId) ) {
            return false;
        }
        if( !providerVlanId.equals(other.providerVlanId) ) {
            return false;
        }
        if( !providerRegionId.equals(other.providerRegionId) ) {
            return false;
        }
        return providerOwnerId.equals(other.providerOwnerId);
    }
    
    public int getAvailableIpAddresses() {
        return availableIpAddresses;
    }

    public void setAvailableIpAddresses(int availableIpAddresses) {
        this.availableIpAddresses = availableIpAddresses;
    }

    public String getCidr() {
        return cidr;
    }

    public void setCidr(String cidr) {
        this.cidr = cidr;
    }

    public SubnetState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(SubnetState currentState) {
        this.currentState = currentState;
    }

    public String getProviderDataCenterId() {
        return providerDataCenterId;
    }

    public void setProviderDataCenterId(String providerDataCenterId) {
        this.providerDataCenterId = providerDataCenterId;
    }

    public String getProviderOwnerId() {
        return providerOwnerId;
    }

    public void setProviderOwnerId(String providerOwnerId) {
        this.providerOwnerId = providerOwnerId;
    }

    public String getProviderRegionId() {
        return providerRegionId;
    }

    public void setProviderRegionId(String providerRegionId) {
        this.providerRegionId = providerRegionId;
    }

    public String getProviderSubnetId() {
        return providerSubnetId;
    }

    public void setProviderSubnetId(String providerSubnetId) {
        this.providerSubnetId = providerSubnetId;
    }

    public String getProviderVlanId() {
        return providerVlanId;
    }

    public void setProviderVlanId(String providerVlanId) {
        this.providerVlanId = providerVlanId;
    }

    public IPVersion[] getSupportedTraffic() {
        return ((supportedTraffic == null || supportedTraffic.length < 1) ? new IPVersion[] { IPVersion.IPV4 } : supportedTraffic);
    }

    public void setSupportedTraffic(@Nonnull IPVersion ... supportedTraffic) {
        if( supportedTraffic.length < 1 ) {
            throw new RuntimeException("You must specify at least one kind of traffic");
        }
        this.supportedTraffic = supportedTraffic;
    }

    public String toString() {
        return (cidr + " [" + providerOwnerId + "/" + providerSubnetId + "]");
    }

    public void setTags(@Nonnull Map<String,String> tags) {
        this.tags = tags;
    }

    @Override
    public @Nonnull Map<String,String> getTags() {
        if( tags == null ) {
            return new HashMap<String, String>();
        }
        return tags;
    }

    @Override
    public void setTag(@Nonnull String key, @Nonnull String value) {
        if( tags == null ) {
            tags = new HashMap<String,String>();
        }
        tags.put(key, value);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
